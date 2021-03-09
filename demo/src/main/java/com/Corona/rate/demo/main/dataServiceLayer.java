package com.Corona.rate.demo.main;

import com.Corona.rate.demo.model.coronaModel;
import com.Corona.rate.demo.model.deathValue;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class dataServiceLayer {

    private static String totalCasedataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static String totalDeathdataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";


    public List<coronaModel> getCoronaData() {
        return coronaData;
    }

    private List<coronaModel> coronaData = new ArrayList<>();

    public List<deathValue> getDeathdata() {
        return deathdata;
    }

    private List<deathValue> deathdata = new ArrayList<>();

    public String getTotalCases() {
        return totalCases;
    }

    String totalCases = String.valueOf(0);

    public String getTotaldeathCases() {
        return totaldeathCases;
    }

    String totaldeathCases = String.valueOf(0);


    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public void totalCasedataFetcher() throws IOException, InterruptedException {
        List<coronaModel> allloc = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(totalCasedataURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int count = 0;
        StringReader in = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            count++;
            coronaModel mod = new coronaModel();
            mod.setIndex(String.valueOf(count));
            String country = record.get("Country/Region");
            mod.setCountry(country);
            String ConfimedCases = record.get(record.size()-1);
            mod.setTotalCases(ConfimedCases);
            totalCases =String.valueOf(Integer.parseInt(totalCases) + Integer.parseInt(ConfimedCases));
            System.out.println(totalCases);
            allloc.add(mod);
        }
        this.coronaData = allloc;
    }

    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public void totalDeathdataFetcher() throws IOException, InterruptedException {
        List<deathValue> allloc = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(totalDeathdataURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int count = 0;
        StringReader in = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            count++;
            deathValue mod = new deathValue();
            mod.setDeathIndex(String.valueOf(count));
            String country = record.get("Country/Region");
            mod.setDeathCountry(country);
            String ConfimedCases = record.get(record.size()-1);
            mod.setTotalDeathCount(ConfimedCases);
            totaldeathCases =String.valueOf(Integer.parseInt(totaldeathCases) + Integer.parseInt(ConfimedCases));
            System.out.println(totaldeathCases);
            allloc.add(mod);
        }
        this.deathdata = allloc;
    }

}
