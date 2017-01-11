package br.com.wswork.retrofit.interfaces;

import br.com.wswork.retrofit.domain.Comment;
import br.com.wswork.retrofit.domain.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface Placeholder {

  @GET("posts/{id}")
  Call<Post> getPost(@Path("id") Long id);

  @GET("posts")
  Call<List<Post>> getPosts();

  @GET("comments/{id}")
  Call<Comment> getComment(@Path("id") Long id);

  @GET("comments")
  Call<List<Comment>> getComments();

}
