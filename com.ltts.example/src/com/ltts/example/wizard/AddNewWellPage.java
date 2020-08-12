package com.ltts.example.wizard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import com.ltts.example.ui.addnewwell.AddNewWellModelMgr;
import com.ltts.example.ui.addnewwell.AddNewWellViewMgr;

public class AddNewWellPage extends WizardPage implements PropertyChangeListener {



	/**
	 * Constructor for AddNewWellPage
	 * 
	 * @param pageName
	 */
	protected AddNewWellPage(String pageName) {
		super(pageName);
		AddNewWellModelMgr.INSTANCE.addChangeListener(this);
	}

	/**
	 * This method is used to create UI for Add New Well Page.
	 */
	@Override
	public void createControl(Composite parent) {

		setTitle("Add New Well");
		parent = AddNewWellViewMgr.INSTANCE.createAddNewViewMgr(parent);
		setControl(parent);
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

	@Override
	public boolean isPageComplete() {
		return true;
	}
}
