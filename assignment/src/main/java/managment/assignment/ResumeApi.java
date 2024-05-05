package managment.assignment;
import java.io.*;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeApi {

    @GetMapping("/resumeApi")
    public void ma() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url("https://drive.google.com/file/d/1VzLV6QJ5pzDjvzRoiUdSFxfPf40gR_gv/view")
                .addHeader("apikey", "UfzaY8riNGanCAj6upnHd4uy3CtC4lin")
                .method("GET",null)
            .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
    }
}
