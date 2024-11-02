package lotto.controller;

import java.util.List;

import lotto.model.LottoBundle;
import lotto.model.LottoCreator;
import lotto.model.Price;
import lotto.model.PurchaseLottoResultGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCreateController {

	private final InputView inputView;
	private final OutputView outputView;

	public LottoCreateController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Price price = getPurchasePrice();
		LottoBundle lottoBundle = purchaseLotto(price);
	}

	private Price getPurchasePrice() {
		try {
			outputView.printPurchasePriceInputMessage();
			int purchasePriceInput = inputView.getPurchasePriceInput();
			return new Price(purchasePriceInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return getPurchasePrice();
		}
	}

	private LottoBundle purchaseLotto(Price price) {
		LottoCreator lottoCreator = new LottoCreator();
		LottoBundle lottoBundle = new LottoBundle(price, lottoCreator);
		PurchaseLottoResultGenerator purchaseLottoResultGenerator = new PurchaseLottoResultGenerator();
		return lottoBundle;
	}
}
