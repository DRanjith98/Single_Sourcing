package com.ltts.example.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class View_1 extends ViewPart {

	String[] fieldsData = { "Salala", "Ghawar" };
	
	
		
		@Override
		public void createPartControl(Composite parent) {
			Composite addWellPageContainer = new Composite(parent, SWT.BORDER);
			GridLayout layout = new GridLayout(2, false);
			layout.verticalSpacing = 15;
			layout.marginTop = 10;
			addWellPageContainer.setLayout(layout);
			addWellPageContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			

			// Well Name
			Label wellNameLabel = new Label(addWellPageContainer, SWT.NONE);
			wellNameLabel.setText("Well Name");
			wellNameLabel.setLayoutData(getLabelGridData());

			Text wellNameText = new Text(addWellPageContainer, SWT.BORDER);
			wellNameText.setLayoutData(getGridData());

			// Easting
			Label eastingLabel = new Label(addWellPageContainer, SWT.NONE);
			eastingLabel.setText("Easting");
			eastingLabel.setLayoutData(getLabelGridData());

			Text eastingText = new Text(addWellPageContainer, SWT.BORDER);
			eastingText.setLayoutData(getGridData());


			// Northing
			Label northingLabel = new Label(addWellPageContainer, SWT.NONE);
			northingLabel.setText("Northing");
			northingLabel.setLayoutData(getLabelGridData());

			Text northingText = new Text(addWellPageContainer, SWT.BORDER);
			northingText.setLayoutData(getGridData());
			

			// Azimuth
			Label azimuthLabel = new Label(addWellPageContainer, SWT.NONE);
			azimuthLabel.setText("Azimuth");
			azimuthLabel.setLayoutData(getLabelGridData());

			Text azimuthText = new Text(addWellPageContainer, SWT.BORDER);
			azimuthText.setLayoutData(getGridData());
			

			// Field
			Label fieldLabel = new Label(addWellPageContainer, SWT.NONE);
			fieldLabel.setText("Field");
			fieldLabel.setLayoutData(getLabelGridData());

			Combo fieldCombo = new Combo(addWellPageContainer, SWT.DROP_DOWN | SWT.READ_ONLY);
			fieldCombo.setItems(fieldsData);
			fieldCombo.setLayoutData(getGridData());

			
			// Well Type
			Label wellTypelabel = new Label(addWellPageContainer, SWT.NONE);
			wellTypelabel.setText("Well Type ");
			wellTypelabel.setLayoutData(getLabelGridData());

			Composite radioComposite = new Composite(addWellPageContainer, SWT.NONE);
			radioComposite.setLayout(new RowLayout());

			Button wellTypeHorizontalRadio = new Button(radioComposite, SWT.RADIO);
			wellTypeHorizontalRadio.setText("Horizontal");
			wellTypeHorizontalRadio.setSelection(true);

			Button wellTypeVerticalRadio = new Button(radioComposite, SWT.RADIO);
			wellTypeVerticalRadio.setText("Vertical");

			Button wellTypeDeviatedRadio = new Button(radioComposite, SWT.RADIO);
			wellTypeDeviatedRadio.setText("Deviated");

			Button wellTypeSWellRadio = new Button(radioComposite, SWT.RADIO);
			wellTypeSWellRadio.setText("S-Well");

			


		}
		
		private GridData getGridData() {
			GridData gridData = new GridData();
			gridData.widthHint = 100;
			gridData.horizontalIndent = 5;
			return gridData;
		}
		
		private GridData getLabelGridData() {
			GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
			gridData.widthHint = 100;
			return gridData;
		}
		

		

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
