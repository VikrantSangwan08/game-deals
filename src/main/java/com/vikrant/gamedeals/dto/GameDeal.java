package com.vikrant.gamedeals.dto;

public class GameDeal {

       
        public GameDeal(){

        }
        
        public GameDeal(String title, String storeID, String normalPrice, Boolean isOnSale, String savings,
            String metacriticScore) {
        this.title = title;
        this.storeID = storeID;
        this.normalPrice = normalPrice;
        this.isOnSale = isOnSale;
        this.savings = savings;
        this.metacriticScore = metacriticScore;
    }


        private String title;
        private String storeID;
        private String normalPrice;
        private Boolean isOnSale;
        private String savings;
        private String metacriticScore;
        public String getTitle() {
            return title;
        }

        
        public void setTitle(String title) {
            this.title = title;
        }
        public String getStoreID() {
            return storeID;
        }
        public void setStoreID(String storeID) {
            this.storeID = storeID;
        }
        public String getNormalPrice() {
            return normalPrice;
        }
        public void setNormalPrice(String normalPrice) {
            this.normalPrice = normalPrice;
        }
        public Boolean getIsOnSale() {
            return isOnSale;
        }
        public void setIsOnSale(Boolean isOnSale) {
            this.isOnSale = isOnSale;
        }
        public String getSavings() {
            return savings;
        }
        public void setSavings(String savings) {
            this.savings = savings;
        }
        public String getMetacriticScore() {
            return metacriticScore;
        }
        public void setMetacriticScore(String metacriticScore) {
            this.metacriticScore = metacriticScore;
        }
}
