package store.config;

import java.io.FileNotFoundException;
import java.util.List;
import store.controller.StoreController;
import store.service.StoreService;
import store.util.file.FileReader;
import store.util.file.FileType;
import store.view.InputView;
import store.view.OutputView;

public class AppConfig {

    public StoreController storeController() {
        return new StoreController(inputView(), outputView(), storeService(), domainFactory());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private StoreService storeService() {
        return new StoreService();
    }

    private DomainFactory domainFactory() {
        return new DomainFactory();
    }
}
