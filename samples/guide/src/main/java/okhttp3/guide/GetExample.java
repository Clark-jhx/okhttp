package okhttp3.guide;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
  //1.创建client客户端
  OkHttpClient client = new OkHttpClient();

  String run(String url) throws IOException {
    //2.创建request
    Request request = new Request.Builder()
        .url(url)
        .build();
    //3.创建call对象
    //4.执行
    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public static void main(String[] args) throws IOException {
    GetExample example = new GetExample();
    String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
    System.out.println(response);
  }
}
