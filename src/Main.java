import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

class FrameInit extends JFrame {
    public FrameInit() {
        this.setLayout(null);

        JButton button1 = new JButton("종료");
        //button1.setFont(new Font("맑은고딕", Font.BOLD, 30));
        button1.setBounds(280, 500, 100, 40);
        this.add(button1);

        JTextArea txt1 = new JTextArea();
        txt1.setLineWrap(true);
        txt1.setBounds(10, 10, 250, 500);
        txt1.setEnabled(false);
        this.add(txt1);


        JTextField name_box = new JTextField("이름 입력");
        name_box.setBounds(280, 10, 100, 30);
        this.add(name_box);

        JButton log_in = new JButton("확인");
        log_in.setBounds(280, 50, 100, 30);
        this.add(log_in);

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solved.ac User Info Rest-API
                try {
                    // One
//                    URL url = new URL("https://solved.ac/api/v3/user/show?handle=LJU0912");
//                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//                    httpConn.setRequestMethod("GET");
//
//                    httpConn.setRequestProperty("Content-Type", "application/json");
//                    httpConn.setConnectTimeout(10000);
//                    httpConn.setReadTimeout(10000);
//
//                    StringBuffer response = new StringBuffer();
//                    String inputLine;
//                    if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), StandardCharsets.UTF_8));
//
//                        while ((inputLine = in.readLine()) != null) {
//                            response.append(inputLine).append("\n");
//                        }
//                        in.close();
//                    }
//                    System.out.println(response);

                    // Two
                    String user_name = name_box.getText();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://solved.ac/api/v3/user/show?handle=" + user_name))
                            .header("Content-Type", "application/json")
                            .method("GET", HttpRequest.BodyPublishers.noBody())
                            .build();
                    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println(response.body());

                    // Print
                    txt1.setText(response.body());
                } catch(Exception err) {
                    err.printStackTrace();
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch(Exception err) {
                    err.printStackTrace();
                }
            }
        });


        setSize(400, 600);
        setTitle("SmartPicker");
        setResizable(false);
        setVisible(true);
    }

}

public class Main {
    public static void main(String[] args) {
        FrameInit f = new FrameInit();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
    }
}