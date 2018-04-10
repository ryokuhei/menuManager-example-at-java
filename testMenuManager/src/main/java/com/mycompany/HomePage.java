package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycompany.menuManager.MenuList;
import com.mycompany.menuManager.MenuModel;
import com.mycompany.menuManager.Presenter;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.Model;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	private Model<String> keyModel = new Model<String>();
	private Model<String> displayModel = new Model<String>();
    private Presenter presenter;
	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		this.presenter = new Presenter();
		MenuModel menu = this.presenter.currentMenu();
		keyModel.setObject(menu.getKey());
		displayModel.setObject(menu.getDisplay());

		
		Form form = new Form("form");
		this.add(form);

		form.add(new Label("key", keyModel));
		form.add(new Label("display", displayModel));
		
		Button prev = new Button("prev") {
			@Override
			public void onSubmit() {
				MenuModel menu = presenter.prevMenu();
				keyModel.setObject(menu.getKey());
				displayModel.setObject(menu.getDisplay());
			}
		};
		form.add(prev);

		Button next = new Button("next") {
			@Override
			public void onSubmit() {

		System.out.println("参照値:" + presenter.hashCode());
				MenuModel menu = presenter.nextMenu();
				keyModel.setObject(menu.getKey());
				displayModel.setObject(menu.getDisplay());
			}
		};
		form.add(next);

    }
}
