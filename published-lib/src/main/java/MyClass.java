import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MyClass {
  String foo() {
    Properties properties = new Properties();
    try {
      properties.load(MyClass.class.getClassLoader().getResource("version.properties").openStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return "published-" + properties.get("version");
  }
}