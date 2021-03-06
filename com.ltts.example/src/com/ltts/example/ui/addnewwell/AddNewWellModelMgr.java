package com.ltts.example.ui.addnewwell;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import com.ltts.example.models.Well;
import com.ltts.example.models.WellDataProvider;
import com.ltts.example.ui.util.MessagesUtil;


public enum AddNewWellModelMgr {

	INSTANCE;

	Well wellModel;
	AddNewWellUI addNewWellUI;
	boolean isValid;
	boolean isFinishEnabled;
	boolean isValidWellName;
	private List<PropertyChangeListener> wellModelChangeisteners = new ArrayList<PropertyChangeListener>();

	private List<Well> wellData = WellDataProvider.wellDataProvider.getWell();
	private List<Well> selectedWellsList = new ArrayList<Well>();

	private static final Device device = Display.getCurrent();;
	private static final Color red = new Color(device, 255, 0, 0);
	private final static Color black = new Color(device, 0, 0, 0);

	/**
	 * provides well Model instance.
	 * 
	 * @return
	 */
	public Well getWellModel() {
		if (wellModel == null) {
			this.createWellModel();
		}
		return wellModel;
	}

	/**
	 * creates well Model instance.
	 */
	public void createWellModel() {
		if (wellModel == null) {
			wellModel = new Well();
		}

	}

	/**
	 * adds the current instance listeners to wellModelChangeisteners.
	 * 
	 * @param newListener
	 */
	public void addChangeListener(PropertyChangeListener newListener) {
		wellModelChangeisteners.add(newListener);
	}

	/**
	 * updates the model values from UI.
	 */
	public void changeModelFromUI() {

		try {

			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellNameText().getText() != null) {
				wellModel.setWellPlanName(AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellNameText().getText());
				notifyListeners(this, "", "", "");
			}

			if (Double.parseDouble(AddNewWellViewMgr.INSTANCE.addNewWellUI.getNorthingText().getText()) != 0.0) {
				wellModel.setNorthing(
						Double.parseDouble((AddNewWellViewMgr.INSTANCE.addNewWellUI.getNorthingText().getText())));
				notifyListeners(this, "", "", "");
			}

			if (Double.parseDouble(AddNewWellViewMgr.INSTANCE.addNewWellUI.getEastingText().getText()) != 0.0) {
				wellModel.setEasting(
						Double.parseDouble((AddNewWellViewMgr.INSTANCE.addNewWellUI.getEastingText().getText())));
				notifyListeners(this, "", "", "");
			}

			if (Double.parseDouble(AddNewWellViewMgr.INSTANCE.addNewWellUI.getAzimuthText().getText()) != 0.0) {
				wellModel.setAzimuth(
						Double.parseDouble((AddNewWellViewMgr.INSTANCE.addNewWellUI.getAzimuthText().getText())));
				notifyListeners(this, "", "", "");
			}

			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getFieldCombo().getText() != null) {
				wellModel.setField(AddNewWellViewMgr.INSTANCE.addNewWellUI.getFieldCombo().getText());
				notifyListeners(this, "", "", "");
			}

			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getReservoirCombo().getText() != null) {
				wellModel.setReservoir(AddNewWellViewMgr.INSTANCE.addNewWellUI.getReservoirCombo().getText());
				notifyListeners(this, "", "", "");
			}

			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeHorizontalRadio().getSelection() == true) {
				wellModel.setType(AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeHorizontalRadio().getText());
				notifyListeners(this, "", "", "");
			}

			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeVerticalRadio().getSelection() == true) {
				wellModel.setType(AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeVerticalRadio().getText());
				notifyListeners(this, "", "", "");
			}
			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeDeviatedRadio().getSelection() == true) {
				wellModel.setType(AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeDeviatedRadio().getText());
				notifyListeners(this, "", "", "");
			}
			if (AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeSWellRadio().getSelection() == true) {
				wellModel.setType(AddNewWellViewMgr.INSTANCE.addNewWellUI.getWellTypeSWellRadio().getText());
				notifyListeners(this, "", "", "");
			}
		} catch (Exception e) {
			MessagesUtil.logError(AddNewWellModelMgr.class.getName(), e.getMessage());
		}
	}

	private void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener listner : wellModelChangeisteners) {
			listner.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	/**
	 * validates the UI components.
	 * 
	 */
	public boolean isValid() {

		isValid = true;
		addNewWellUI = AddNewWellViewMgr.INSTANCE.getAddNewWellUI();

		if (addNewWellUI.getCheckBoxButton().getSelection() == true) {

			if (addNewWellUI.getWellNameText().getText().isEmpty()
					|| Double.parseDouble((addNewWellUI.getNorthingText().getText())) == 0.0
					|| Double.parseDouble((addNewWellUI.getEastingText().getText())) == 0.0
					|| (addNewWellUI.getAzimuthText().getText().isEmpty())
					|| addNewWellUI.getFieldCombo().getText().isEmpty()
					|| addNewWellUI.getReservoirCombo().getText().isEmpty() || MessagesUtil.isValid == false) {

				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * updates the selected wells to the list.
	 */
	private void updateSelectedWells() {

		AddNewWellModelMgr.INSTANCE.selectedWellsList.clear();

		for (int i = 0; i < wellData.size(); i++) {
			if (wellData.get(i).isChecked()) {
				isFinishEnabled = true;
				selectedWellsList.add(wellData.get(i));
			}
		}
	}

	/**
	 * Updates new well details to the selected list and model.
	 */
	private void updateWellDetails() {

		addNewWellUI = AddNewWellViewMgr.INSTANCE.getAddNewWellUI();
		Well well = new Well();

		if (addNewWellUI.getCheckBoxButton().getSelection() == true) {

			well.setWellPlanName(addNewWellUI.getWellNameText().getText());
			well.setEasting(Double.parseDouble(addNewWellUI.getEastingText().getText()));
			well.setNorthing(Double.parseDouble(addNewWellUI.getNorthingText().getText()));
			well.setAzimuth(Double.parseDouble(addNewWellUI.getAzimuthText().getText()));
			well.setField(addNewWellUI.getFieldCombo().getText());
			well.setReservoir(addNewWellUI.getReservoirCombo().getText());
			well.setType(setWellType());
			well.setChecked(true);

			wellData.add(well);
			selectedWellsList.add(well);
			isFinishEnabled = true;

		}
	}

	/**
	 * checks for the selected radio button and returns the appropriate text.
	 * 
	 * @return
	 */
	private String setWellType() {
		if (addNewWellUI.getWellTypeHorizontalRadio().getSelection() == true) {
			return addNewWellUI.getWellTypeHorizontalRadio().getText();
		}
		if (addNewWellUI.getWellTypeVerticalRadio().getSelection() == true) {
			return addNewWellUI.getWellTypeVerticalRadio().getText();
		}
		if (addNewWellUI.getWellTypeDeviatedRadio().getSelection() == true) {
			return addNewWellUI.getWellTypeDeviatedRadio().getText();
		}
		if (addNewWellUI.getWellTypeSWellRadio().getSelection() == true) {
			return addNewWellUI.getWellTypeSWellRadio().getText();
		}
		return null;
	}

	/**
	 * checks the Well Name's uniqueness and if it is valid updates the well details
	 * and selected wells.
	 * 
	 * @return
	 */
	public boolean finishPressed() {
		isValidWellName = true;
		isFinishEnabled = false;
		if (addNewWellUI.getCheckBoxButton().getSelection() == true) {

			for (int i = 0; i < wellData.size(); i++) {
				if (isValidWellName(wellData.get(i).getWellPlanName(), addNewWellUI.getWellNameText().getText())) {
					MessagesUtil.displayErrorDialog(addNewWellUI.getWellNameText().getText() + " already exists");
					isValidWellName = false;
					break;
				}
			}
			if (isValidWellName) {

				updateSelectedWells();
				updateWellDetails();
			} else {
				isFinishEnabled = false;
			}
		} else {

			updateSelectedWells();
		}

	

		return isFinishEnabled;
	}

	/**
	 * return true if the well name is unique.
	 * 
	 * @return
	 */

	public boolean isValidWellName(String existWellName, String newWellName) {
		if (existWellName.equals(newWellName)) {
			return true;
		}
		return false;
	}

	/**
	 * validates the double value and sets the foreground accordingly.
	 * 
	 * @param textItem
	 * @param minValue
	 * @param maxValue
	 */
	public void checkValidDouble(Text textItem, Double minValue, Double maxValue) {
		if (MessagesUtil.restrictEnteredChars(textItem.getText(), minValue, maxValue)) {
			textItem.setForeground(black);
		} else {
			textItem.setForeground(red);
		}
	}


}
