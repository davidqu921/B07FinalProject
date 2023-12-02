package com.example.b07projectapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import androidx.annotation.NonNull;

import com.example.b07projectapp.login_module.Login;
import com.example.b07projectapp.login_module.LoginModel;
import com.example.b07projectapp.login_module.LoginPresenter;
import com.example.b07projectapp.login_module.LoginView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

@RunWith(MockitoJUnitRunner.class)

public class LoginPresenterTest {

    @Mock
    private Login mockView;

    @Mock
    private LoginModel mockModel;

    @Captor
    private ArgumentCaptor<ValueEventListener> valueEventListenerCaptor;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginUserSuccess() {
        when(mockView.getUsername()).thenReturn("j4");
        when(mockView.getPassword()).thenReturn("3456");
        LoginPresenter mockPresenter = new LoginPresenter(mockView,mockModel);
        mockPresenter.loginUser();

        verify(mockModel).loginUser(eq("j4"), eq("3456"), valueEventListenerCaptor.capture());
        valueEventListenerCaptor.getValue().onDataChange(createDataSnapshot("3456"));

        verify(mockView).showSuccessMessage("J","j4");
        verifyNoMoreInteractions(mockView);
    }


    @Test
    public void loginUserWrongPassword() {
        when(mockView.getUsername()).thenReturn("j4");
        when(mockView.getPassword()).thenReturn("34567");
        LoginPresenter mockPresenter = new LoginPresenter(mockView,mockModel);
        mockPresenter.loginUser();

        verify(mockView).showErrorMessage("Wrong Password");
        verifyNoMoreInteractions(mockView);
    }

    @Test
    public void loginUserNonexistentUser() {
        when(mockView.getUsername()).thenReturn("shizhuo");
        when(mockView.getPassword()).thenReturn("123456");
        LoginPresenter mockPresenter = new LoginPresenter(mockView,mockModel);
        mockPresenter.loginUser();

        verify(mockModel).loginUser(eq("shizhuo"), eq("123456"), valueEventListenerCaptor.capture());
        valueEventListenerCaptor.getValue().onDataChange(createEmptyDataSnapshot());

        verify(mockView).showErrorMessage("Wrong Password or Username");
        verifyNoMoreInteractions(mockView);
    }

    @Test
    public void loginUserEmptyUsernameOrPassword() {
        when(mockView.getUsername()).thenReturn("");
        when(mockView.getPassword()).thenReturn("");

        LoginPresenter mockPresenter = new LoginPresenter(mockView,mockModel);
        mockPresenter.loginUser();

        verify(mockView).showErrorMessage("Please enter your username or password");
        verifyNoMoreInteractions(mockView, mockModel);
    }

    @Test
    public void openSignUpActivity() {

        LoginPresenter mockPresenter = new LoginPresenter(mockView,mockModel);
        mockPresenter.openSignUpActivity();

        verify(mockView).startActivity(any());
        verifyNoMoreInteractions(mockView);
    }

    @NonNull
    private DataSnapshot createDataSnapshot(String password) {
        DataSnapshot dataSnapshot = mock(DataSnapshot.class);
        DataSnapshot childSnapshot = mock(DataSnapshot.class);
        when(dataSnapshot.child(anyString())).thenReturn(childSnapshot);
        when(childSnapshot.getValue()).thenReturn(password);
        return dataSnapshot;
    }

    private DataSnapshot createEmptyDataSnapshot() {
        return mock(DataSnapshot.class);
    }
}