package async;


import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {

		Option<Ceo> result = Option.of(ceos.toStream().filter(c -> c.id == ceo_id).get());

		CompletableFuture<Option<Ceo>> completableFutureCeo = CompletableFuture.supplyAsync(() -> result);

		return completableFutureCeo;

  }


  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {

		Option<Enterprise> result = Option.of(enterprises.toStream().filter(c -> c.ceo_id == ceo_id).get());

		CompletableFuture<Option<Enterprise>> completableFutureEntreprise = CompletableFuture.supplyAsync(() -> result);

		return completableFutureEntreprise;
	}


  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {

		Option<Ceo> resultCeo = Option.of(ceos.toStream().filter(c -> c.id == ceo_id).get());

		Option<Enterprise> resultEntreprise = Option.of(enterprises.toStream().filter(c -> c.ceo_id == ceo_id).get());

		Tuple2<Option<Ceo>, Option<Enterprise>> tuple = Tuple.of(resultCeo, resultEntreprise);

		CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFutureEntreprise = CompletableFuture
				.supplyAsync(() -> tuple);

		return completableFutureEntreprise;

	}

}

