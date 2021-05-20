package Client.Views.LogInView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.LogInViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginViewController implements ViewController
{
    @FXML Button logInButton;
    @FXML TextField textField;

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
        viewModel.logIn();
        textField.clear();
    }
}