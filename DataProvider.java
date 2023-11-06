import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataProvider {
    // Update the URL to the NBP XML source
    private String url = "https://www.nbp.pl/kursy/xml/lasta.xml";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getData() {
        try {
            URL xmlUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) xmlUrl.openConnection();

            // Set the request method to GET (you can change it if needed)
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response data from the connection
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // Convert the response data to a byte array
                byte[] data = outputStream.toByteArray();


                // Close the streams and disconnect the connection
                outputStream.close();
                inputStream.close();
                connection.disconnect();

                return data;
            } else {
                // Handle the case where the HTTP request was not successful
                System.err.println("HTTP request failed with response code: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


