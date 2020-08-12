package com.ltts.example;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import com.ltts.example.wizard.WellsWizard;


public class WizardHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WizardDialog wizardDialog = new WizardDialog(Display.getDefault().getActiveShell(), new WellsWizard());
		wizardDialog.setPageSize(700, 400);
		wizardDialog.open();
		return null;
	}
}
