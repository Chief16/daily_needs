package com.example.dailynd.Callback;

import com.example.dailynd.Model.CommentModel;

import java.util.List;

public interface ICommentCallbackListener {

    void onCommentLoadSuccess(List<CommentModel> commentModels);
    void onCommentLoadFailed(String message);
}
