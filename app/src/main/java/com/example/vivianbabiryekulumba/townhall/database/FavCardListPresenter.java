package com.example.vivianbabiryekulumba.townhall.database;

public class FavCardListPresenter {

    private FavCardDao favCardDao;
    private FavCard[] favCards = {};
    private FavCardListPresenter.FavCardListPresentation favCardListPresentation;

    public FavCardListPresenter(FavCardDao favCardDao) {
        this.favCardDao = favCardDao;
    }

    public void attach(FavCardListPresenter.FavCardListPresentation presentation) {
        this.favCardListPresentation = presentation;
    }

    public void detach() {
        favCardListPresentation = null;
    }


    public void addFavCard(final String fav_title, String fav_summary, String fav_locality_address, String fav_locality_city) {
        new Thread(new Runnable() {
            @Override public void run() {
                favCardDao.addFavCard(new FavCard(fav_title, fav_summary, fav_locality_address, fav_locality_city));
            }
        }).start();
    }

    public void bindView(FavCardListItem favCardListItem, int position) {
        favCardListItem.setFavCardTitle(favCards[position].fav_title);
        favCardListItem.setFavCardSummary(favCards[position].fav_summary);
        favCardListItem.setFavCardLocalAddress(favCards[position].fav_locality_address);
        favCardListItem.setFavCardLocalCity(favCards[position].fav_locality_city);
    }

    public int getItemCount() {
        return favCards.length;
    }

    public void onFavCardChanged(FavCard[] favCards) {
        this.favCards = favCards;

        if (favCardListPresentation != null) {
            favCardListPresentation.notifyDataSetChanged();
        }
    }

    public interface FavCardListPresentation{
        void notifyDataSetChanged();
    }

    public interface FavCardListItem{
        void setFavCardTitle(String fav_title);
        void setFavCardSummary(String fav_summary);
        void setFavCardLocalAddress(String fav_locality_address);
        void setFavCardLocalCity(String fav_locality_city);
    }
}
