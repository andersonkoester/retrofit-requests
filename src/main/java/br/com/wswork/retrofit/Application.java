package br.com.wswork.retrofit;

import br.com.wswork.retrofit.domain.Comment;
import br.com.wswork.retrofit.domain.Post;
import br.com.wswork.retrofit.interfaces.Placeholder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Application {

  public static void main(String[] args) {

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://jsonplaceholder.typicode.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();

    Placeholder api = retrofit.create(Placeholder.class);

    // https://jsonplaceholder.typicode.com/posts/2
    Call<Post> getPost = api.getPost(2L);

    // https://jsonplaceholder.typicode.com/posts
    Call<List<Post>> getPosts = api.getPosts();

    // https://jsonplaceholder.typicode.com/comments/3
    Call<Comment> getComment = api.getComment(3L);

    // https://jsonplaceholder.typicode.com/comments
    Call<List<Comment>> getComments = api.getComments();

    try {
      Post p = getPost.execute().body();
      System.out.println(p);
//      List<Post> posts = getPosts.execute().body();
//      for( Post post : posts ){
//        System.out.println(post);
//      }

      Comment c = getComment.execute().body();
      System.out.println(c);

    }catch (Exception e){

    }


  }

}