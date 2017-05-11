package com.example.administrator.xrefreshviewdemo.ormlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.ormlite.bean.Article;
import com.example.administrator.xrefreshviewdemo.ormlite.bean.User;
import com.example.administrator.xrefreshviewdemo.ormlite.db.ArticleDao;
import com.example.administrator.xrefreshviewdemo.ormlite.db.UserDao;

public class OrmLiteActivity extends AppCompatActivity {
    Context context;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm_lite);
        initView();
        context = this;
        testAddArticle();
        testGetArticleById();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, OrmLiteActivity.class);
        context.startActivity(starter);
    }

    public void testAddArticle() {
        User u = new User();
        u.setName("王勇");
        new UserDao(context).add(u);
        Article article = new Article();
        article.setTitle("ORMLite的使用");
        article.setUser(u);
        new ArticleDao(context).add(article);
    }

    public void testGetArticleById() {
        Article article = new ArticleDao(context).get(1);
        tv_content.setText(article.getUser().toString() + " , " + article.getTitle());
//        Logger.d(article.getUser().toString() + " , " + article.getTitle());
    }

    private void initView() {
        tv_content = (TextView) findViewById(R.id.tv_content);
    }
}
