import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class FrameInit extends JFrame {
    public FrameInit() {
        this.setLayout(null);

        JButton button = new JButton("버튼");
        button.setBounds(100, 100, 50, 50);
        this.add(button);




        setSize(300, 200);
        setTitle("SmartPicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

public class Main {
    public static void main(String[] args) {
        FrameInit f = new FrameInit();

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Solved.ac User Info Rest-API
        try {
            URL url = new URL("https://solved.ac/api/v3/user/show?handle=LJU0912");
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");

            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setConnectTimeout(10000);
            httpConn.setReadTimeout(10000);

            StringBuffer response = new StringBuffer();
            String inputLine;
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), StandardCharsets.UTF_8));

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine).append("\n");
                }
                in.close();
            }
            System.out.println(response);
        } catch(Exception e) {
            e.printStackTrace();
        }





    }
}