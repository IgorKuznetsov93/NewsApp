
package com.example.android.newsapp;

import java.util.HashMap;
import java.util.Map;

public class Fields {

    private String headline;
    private String standfirst;
    private String trailText;
    private String byline;
    private String main;
    private String body;
    private String newspaperPageNumber;
    private String wordcount;
    private String commentable;
    private String firstPublicationDate;
    private String isInappropriateForSponsorship;
    private String isPremoderated;
    private String lastModified;
    private String newspaperEditionDate;
    private String productionOffice;
    private String publication;
    private String shortUrl;
    private String shouldHideAdverts;
    private String showInRelatedContent;
    private String thumbnail;
    private String legallySensitive;
    private String lang;
    private String bodyText;
    private String charCount;
    private String shouldHideReaderRevenue;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getStandfirst() {
        return standfirst;
    }

    public void setStandfirst(String standfirst) {
        this.standfirst = standfirst;
    }

    public String getTrailText() {
        return trailText;
    }

    public void setTrailText(String trailText) {
        this.trailText = trailText;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNewspaperPageNumber() {
        return newspaperPageNumber;
    }

    public void setNewspaperPageNumber(String newspaperPageNumber) {
        this.newspaperPageNumber = newspaperPageNumber;
    }

    public String getWordcount() {
        return wordcount;
    }

    public void setWordcount(String wordcount) {
        this.wordcount = wordcount;
    }

    public String getCommentable() {
        return commentable;
    }

    public void setCommentable(String commentable) {
        this.commentable = commentable;
    }

    public String getFirstPublicationDate() {
        return firstPublicationDate;
    }

    public void setFirstPublicationDate(String firstPublicationDate) {
        this.firstPublicationDate = firstPublicationDate;
    }

    public String getIsInappropriateForSponsorship() {
        return isInappropriateForSponsorship;
    }

    public void setIsInappropriateForSponsorship(String isInappropriateForSponsorship) {
        this.isInappropriateForSponsorship = isInappropriateForSponsorship;
    }

    public String getIsPremoderated() {
        return isPremoderated;
    }

    public void setIsPremoderated(String isPremoderated) {
        this.isPremoderated = isPremoderated;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getNewspaperEditionDate() {
        return newspaperEditionDate;
    }

    public void setNewspaperEditionDate(String newspaperEditionDate) {
        this.newspaperEditionDate = newspaperEditionDate;
    }

    public String getProductionOffice() {
        return productionOffice;
    }

    public void setProductionOffice(String productionOffice) {
        this.productionOffice = productionOffice;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShouldHideAdverts() {
        return shouldHideAdverts;
    }

    public void setShouldHideAdverts(String shouldHideAdverts) {
        this.shouldHideAdverts = shouldHideAdverts;
    }

    public String getShowInRelatedContent() {
        return showInRelatedContent;
    }

    public void setShowInRelatedContent(String showInRelatedContent) {
        this.showInRelatedContent = showInRelatedContent;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLegallySensitive() {
        return legallySensitive;
    }

    public void setLegallySensitive(String legallySensitive) {
        this.legallySensitive = legallySensitive;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getCharCount() {
        return charCount;
    }

    public void setCharCount(String charCount) {
        this.charCount = charCount;
    }

    public String getShouldHideReaderRevenue() {
        return shouldHideReaderRevenue;
    }

    public void setShouldHideReaderRevenue(String shouldHideReaderRevenue) {
        this.shouldHideReaderRevenue = shouldHideReaderRevenue;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
