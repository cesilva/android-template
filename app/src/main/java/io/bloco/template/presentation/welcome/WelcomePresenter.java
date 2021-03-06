package io.bloco.template.presentation.welcome;

import io.bloco.template.common.di.PerActivity;
import io.bloco.template.data.models.Card;
import io.bloco.template.domain.GetAllCards;
import java.util.List;
import javax.inject.Inject;

@PerActivity public class WelcomePresenter implements WelcomeContract.Presenter,
    GetAllCards.Callback {

  private final GetAllCards getAllCards;
  private WelcomeContract.View view;

  @Inject public WelcomePresenter(GetAllCards getAllCards) {
    this.getAllCards = getAllCards;
  }

  @Override public void start(WelcomeContract.View view) {
    this.view = view;
    getAllCards.get(this);
  }

  @Override public void onGetAllCards(List<Card> cards) {
    if (!cards.isEmpty()) {
      view.showCards(cards);
    }
  }
}
