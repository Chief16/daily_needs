package com.example.dailyndserver.EventBus;

import com.example.dailyndserver.model.AddonModel;

public class SelectAddonModel {
    private AddonModel addonModel;

    public SelectAddonModel(AddonModel addonModel) {
        this.addonModel = addonModel;
    }

    public AddonModel getAddonModel() {
        return addonModel;
    }

    public void setAddonModel(AddonModel addonModel) {
        this.addonModel = addonModel;
    }
}
