package com.ltts.example.ui.addnewwell;

import org.eclipse.swt.widgets.Composite;

import com.ltts.example.models.Well;



public enum AddNewWellViewMgr {

	INSTANCE;

	AddNewWellUI addNewWellUI;
	Well wellModel;

	/**
	 * instantiates model instance and updates UI with the values.
	 * 
	 * @param parent
	 * @return
	 */
	public Composite createAddNewViewMgr(Composite parent) {
		addNewWellUI = new AddNewWellUI(parent);
		wellModel = AddNewWellModelMgr.INSTANCE.getWellModel();
		new AddNewWellUISupport(addNewWellUI, wellModel);

		return addNewWellUI.getAddWellPageContainer();
	}

	/**
	 * get AddNewWellUI
	 * 
	 * @return
	 */
	public AddNewWellUI getAddNewWellUI() {
		return addNewWellUI;
	}

}

