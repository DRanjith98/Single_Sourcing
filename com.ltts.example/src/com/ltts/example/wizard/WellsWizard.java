package com.ltts.example.wizard;

import org.eclipse.jface.wizard.Wizard;

import com.ltts.example.ui.addnewwell.AddNewWellModelMgr;
import com.ltts.example.ui.util.MessagesUtil;



public class WellsWizard extends Wizard {

	LoginPage loginPage;
	
	static AddNewWellPage addNewWellPage;

	boolean isFinishEnabled;
	boolean isValid;

	/**
	 * Provides the title for the wizard.
	 */
	@Override
	public String getWindowTitle() {
		return "Well Selection Wizard";
	}

	/**
	 * Adds the pages before the wizard opens.
	 */
	@Override
	public void addPages() {
		loginPage = new LoginPage("Login Page");
		
		addNewWellPage = new AddNewWellPage("Add New Well Page");
		addPage(loginPage);
		
		addPage(addNewWellPage);
	}

	/**
	 * Checks for the selected wells and stores the corresponding well objects in
	 * the selectedWellsList on click of Finish button.
	 * 
	 */
	@Override
	public boolean performFinish() {
		isFinishEnabled = false;
		if (getContainer().getCurrentPage().isPageComplete()) {
			if (AddNewWellModelMgr.INSTANCE.finishPressed()) {

			

				isFinishEnabled = true;
			}
		}

		return isFinishEnabled;
	}

	/**
	 * Enable/disable the finish button in Add New Well Page.
	 */
	@Override
	public boolean canFinish() {
		isValid = false;

		if (getContainer().getCurrentPage().isPageComplete()) {
			try {
				if (AddNewWellModelMgr.INSTANCE.isValid()) {
					isValid = true;
				}

			} catch (Exception e) {
				MessagesUtil.logError(this.getClass().getName(), e.getMessage());
			}
		}
		return isValid;
	}
}
