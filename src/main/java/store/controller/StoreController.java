package store.controller;

import java.io.FileNotFoundException;
import java.util.List;
import store.config.DomainFactory;
import store.domain.Product;
import store.domain.Promotion;
import store.service.StoreService;
import store.util.exception.ErrorMessage;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    private InputView inputView;
    private OutputView outputView;
    private StoreService storeService;
    private DomainFactory domainFactory;

    public StoreController(InputView inputView, OutputView outputView, StoreService storeService, DomainFactory domainFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.storeService = storeService;
        this.domainFactory = domainFactory;
    }

    public void run(){
        try {
            List<Product>products = domainFactory.createProduct();
            List<Promotion> promotions = domainFactory.createPromotion();
            String storeList = storeService.createStoreList(products);
            outputView.displayProducts(storeList);
        } catch (FileNotFoundException ffe) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FILE_FOUND.getMessage());
        }
    }




}
