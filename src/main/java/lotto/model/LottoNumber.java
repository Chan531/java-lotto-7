package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

	static {
		IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
				.forEach(number -> lottoNumberCache.put(number, new LottoNumber(number)));
	}

	private final int number;

	private LottoNumber(int number) {
		checkLottoNumberRange(number);
		this.number = number;
	}

	private void checkLottoNumberRange(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하이어야 합니다.");
		}
	}

	public static LottoNumber from(int number) {
		return lottoNumberCache.get(number);
	}
}
