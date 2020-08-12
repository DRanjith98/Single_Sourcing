package com.ltts.example.ui.login;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import com.ltts.example.models.UserModel;

public class LoginUISupport {

	LoginUI loginUI;
	UserModel userModel;

	public LoginUISupport(LoginUI loginUI, UserModel userModel) {
		this.loginUI = loginUI;
		addModifyListener();
	}

	/**
	 * Method to create listeners.
	 */
	private void addModifyListener() {

		loginUI.userNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				LoginModelMgr.INSTANCE.changeModelFromUI();
			}
		});
		loginUI.passwordText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				LoginModelMgr.INSTANCE.changeModelFromUI();
			}
		});

	}
}
