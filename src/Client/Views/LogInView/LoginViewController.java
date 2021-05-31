package Client.Views.LogInView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.LogInViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;


public class LoginViewController implements ViewController
{
    @FXML Button logInButton;
    @FXML TextField textField;
    @FXML Label wrongPassword;

    private ViewHandler viewHandler;
    private LogInViewModel viewModel;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        this.viewModel = viewModelFactory.getLogInViewModel();
        textField.textProperty().bindBidirectional(viewModel.passwordProperty());
    }

    public void logIn(ActionEvent event)
    {
        if (viewModel.logIn())
            viewHandler.openMainMenu();
        {
            textField.clear();
            wrongPassword.setVisible(true);
        }
    }

    public void onBackButton(ActionEvent evt) throws SQLException, RemoteException {
        viewHandler.openLogInMenu();
    }
}
