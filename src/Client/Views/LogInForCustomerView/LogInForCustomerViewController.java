package Client.Views.LogInForCustomerView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.ViewModel.LogInCustomerViewModel;
import Client.Model.Customer;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LogInForCustomerViewController implements ViewController
{
  @FXML TextField emailField;
  @FXML TextField passwordField;

  private ViewHandler viewHandler;
  private LogInCustomerViewModel logInCustomerViewModel;

  private Customer customer;


  private Customer customer;

  public void setCustomer(Customer customer)
  {
    this.customer=customer;
  }

  private String[] splitCpr(String cprFull){
    String[] parts = cprFull.split("/");
    return parts;
  }
  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.logInCustomerViewModel = viewModelFactory.getLogInCustomerViewModel();
  }

  public void logIn() throws RemoteException, SQLException
  {
    if (logInCustomerViewModel.checkForPassword(emailField.getText(),passwordField.getText()))
      viewHandler.openMenuCustomerView(customer); //We are missing function to set Customer
    emailField.clear();
    passwordField.clear();
  }

  public void onBackButton() throws SQLException, RemoteException
  {
    viewHandler.openLogInMenu();
  }

  public void signUp() throws SQLException, RemoteException
  {
    viewHandler.openAddPersonalAccount();
  }
}
