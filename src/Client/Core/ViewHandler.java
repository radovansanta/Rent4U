package Client.Core;

import Client.Views.LogInView.LoginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private static ViewHandler instance = new ViewHandler();

  public static ViewHandler getInstance(){
    return instance;
  }

  private Stage stage;

  private ViewHandler() {}

  public void start() throws IOException
  {
    stage = new Stage();
    open();
  }

  private void openToLogInView()
  {
    Scene logInViewScene = ViewFactory.getScene("LogIn");
    stage.setTitle(String.valueOf(logInViewScene));
    stage.show();
  }

  public void open()
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/LogInView/LoginView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    LoginViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("LogIn");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

}
