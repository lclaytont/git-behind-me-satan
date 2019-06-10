package com.clayterry.gitBehindMeSatan.ui.search;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.clayterry.gitBehindMeSatan.ui.common.BaseActivity;
import com.clayterry.gitBehindMeSatan.ui.repoList.RepoListActivity;
import com.clayterry.gitbehindmesatan.R;

public class SearchActivity extends BaseActivity {

    EditText mEditText;
    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);

        mEditText = findViewById(R.id.search_editText);
        mButton = findViewById(R.id.search_btn);

        mEditText.setOnTouchListener((v, event) -> {
            mEditText.setText("");
            v.performClick();
            return false;
        });

        mButton.setOnClickListener(v -> {
            String searchParam = mEditText.getText().toString();
            if (searchParam.equals(R.string.editText_helper) || searchParam.equals(""))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setMessage("Please provide a valid topic")
                        .setPositiveButton("Ok", (dialog, which) -> {
                           // Dismiss Alert
                        });

                builder.show();
            } else
            {
                Intent navToRepo = new Intent(this, RepoListActivity.class);
                navToRepo.putExtra("search_param", searchParam);
                startActivity(navToRepo);
            }
        });


    }
}
