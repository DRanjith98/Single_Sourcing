package com.ltts.example.wizard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.ltts.example.ui.login.LoginModelMgr;
import com.ltts.example.ui.login.LoginViewMgr;

public class LoginPage extends WizardPage implements PropertyChangeListener {

	
	public Text userNameText = null;
	public Text passwordText = null;

	/**
	 * Constructor for Login
	 * 
	 * @param pageName
	 */
	protected LoginPage(String pageName) {
		super(pageName);
		LoginModelMgr.INSTANCE.addChangeListener(this);

	}

	/**
	 * This method is used to create UI for login page.
	 */
	@Override
	public void createControl(Composite parent) {

		setTitle("Login_Page");
		parent = LoginViewMgr.INSTANCE.createLoginViewUI(parent);
		setControl(parent);

	}

	/**
	 * Enable/disable the Next Button in Login Page.
	 */
	@Override
	public boolean canFlipToNextPage() {
		if (LoginModelMgr.INSTANCE.getUserModel().getUserName() != null
				&& LoginModelMgr.INSTANCE.getUserModel().getPassword() != null) {
			if (!LoginModelMgr.INSTANCE.getUserModel().getUserName().isEmpty()
					&& !LoginModelMgr.INSTANCE.getUserModel().getPassword().isEmpty()) {

				return true;
			}
		}
		return false;
	}

	/**
	 * updates the wizard buttons.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (this.getWizard().getContainer() != null) {
			this.getWizard().getContainer().updateButtons();
		}
	}

	/**
	 * Validates the user and returns the next page.
	 */
	@Override
	public IWizardPage getNextPage() {
		if (LoginModelMgr.INSTANCE.isValid(LoginModelMgr.INSTANCE.getUserModel().getUserName(),
				LoginModelMgr.INSTANCE.getUserModel().getPassword())) {
			return WellsWizard.addNewWellPage;
		}
		return null;
	}

	/**
	 * @return false
	 */
	@Override
	public boolean isPageComplete() {
		return false;
	}
}