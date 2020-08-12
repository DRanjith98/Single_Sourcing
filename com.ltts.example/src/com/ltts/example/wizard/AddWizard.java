//package com.ltts.example.wizard;
//
//import org.eclipse.jface.wizard.Wizard;
//
//public class AddWizard extends Wizard {
//
//	
//	
//	User user;
//	
//	/**
//	 * Provides the title for the wizard.
//	 */
//	@Override
//	public String getWindowTitle() {
//		return "Wizard";
//	}
//
//	/**
//	 * Adds the pages before the wizard opens.
//	 */
//	@Override
//	public void addPages() {
//		user = new User("User");
//		
//		addPage(user);
//	}
//
//	
//	@Override
//	public boolean performFinish() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
