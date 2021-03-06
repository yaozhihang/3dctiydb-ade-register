
package org.citydb.plugins.ade_manager;

import java.util.Locale;

import org.citydb.plugin.ApplicationStarter;
import org.citydb.plugin.Plugin;
import org.citydb.plugin.extension.config.ConfigExtension;
import org.citydb.plugin.extension.config.PluginConfigEvent;
import org.citydb.plugin.extension.view.View;
import org.citydb.plugin.extension.view.ViewController;
import org.citydb.plugin.extension.view.ViewExtension;
import org.citydb.plugins.ade_manager.config.ConfigImpl;
import org.citydb.plugins.ade_manager.gui.ADEManagerView;

public class ADEManagerPlugin implements Plugin, ViewExtension, ConfigExtension<ConfigImpl> {
	
	private ADEManagerView view;
	private ConfigImpl config;
	
	public static void main(String[] args) {
		ApplicationStarter starter = new ApplicationStarter();
		starter.run(args, new ADEManagerPlugin());
	}

	public void init(ViewController viewController, Locale locale) {
		view = new ADEManagerView(viewController, this);
		loadSettings();
		switchLocale(locale);
	}

	public void shutdown() {
		saveSettings();
	}

	public void switchLocale(Locale newLocale) {
		view.doTranslation();
	}

	public View getView() {
		return view;
	}
	
	public void loadSettings() {
		view.loadSettings();
	}

	public void saveSettings() {
		view.saveSettings();
	}

	@Override
	public void configLoaded(ConfigImpl config2) {
		boolean reload = this.config != null;		
		setConfig(config2);
		
		if (reload)
			loadSettings();	
		
	}

	@Override
	public ConfigImpl getConfig() {
		return config;
	}

	public void setConfig(ConfigImpl config) {
		this.config = config;
	}
	
	@Override
	public void handleEvent(PluginConfigEvent event) {
		switch (event) {
		case RESET_DEFAULT_CONFIG:
			this.config = new ConfigImpl();
			loadSettings();
			break;
		case PRE_SAVE_CONFIG:
			saveSettings();
			break;
		}
	}
	
}
