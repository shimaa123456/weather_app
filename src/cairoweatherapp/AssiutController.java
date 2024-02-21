
package cairoweatherapp;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.event.ActionEvent;
import org.json.simple.JSONArray;
public class AssiutController implements Initializable {

   
   
    @FXML
    private ImageView weatherConditionImage;

    @FXML
    private Label temperatureText;
      
    @FXML
    private Label weatherConditionDesc;

    @FXML
    private Label humidityText;

    @FXML
    private Label windspeedText;
   
        // Add labels for the first day
    @FXML
    private Label date1;
    
    @FXML
    private Label con1;
    
    @FXML
    private Label temp1;
    
            // Add labels for the second day
    @FXML
    private Label date2;
    
    @FXML
    private Label con2;
    
    @FXML
    private Label temp2;
    
            // Add labels for the third day
    @FXML
    private Label date3;
    
    @FXML
    private Label con3;
    
    @FXML
    private Label temp3;
    
            // Add labels for the four day
    @FXML
    private Label date4;
    
    @FXML
    private Label con4;
    
    @FXML
    private Label temp4;
    
            // Add labels for the five day
    @FXML
    private Label date5;
    
    @FXML
    private Label con5;
    
    @FXML
    private Label temp5;
    
            // Add labels for the six day
    @FXML
    private Label date6;
    
    @FXML
    private Label con6;
    
    @FXML
    private Label temp6;
    
            // Add labels for the seven day
    @FXML
    private Label date7;
    
    @FXML
    private Label con7;
    
    @FXML
    private Label temp7;

    //
    
     @FXML
    private ImageView weatherConditionImage2;
     
     @FXML
    private ImageView weatherConditionImage3;
          
     @FXML
    private ImageView weatherConditionImage4;
     
     @FXML
    private ImageView weatherConditionImage5;
                    
     @FXML
    private ImageView weatherConditionImage6;
     @FXML
    private ImageView weatherConditionImage7;
     
      @FXML
    private ImageView weatherConditionImage8;
      // Add labels for the second day


//    @FXML
//    private Button searchButton;
//
    private JSONObject weatherData;
    private JSONObject weatherData2; 
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      handleSearch(); 
    }
    
    
    
   
    

     @FXML
    private void handleSearch() {
        // set location of current city
        String userInput = "Assiut";
       
        // validate input - remove whitespace to ensure non-empty text
        if (userInput.replaceAll("\\s", "").length() <= 0) {
            return;
        }
        
        // retrieve weather data  of the current time
        weatherData = cairoApi.getWeatherData(userInput);
        

        // update weather image
        String weatherCondition = (String) weatherData.get("weather_condition");
        updateWeatherImage(weatherCondition);

        // update temperature text
        double temperature = (double) weatherData.get("temperature");
        temperatureText.setText(temperature + " C");

        // update weather condition text
        weatherConditionDesc.setText(weatherCondition);

        // update humidity text
        long humidity = (long) weatherData.get("humidity");
        humidityText.setText("Humidity " + humidity + "%");

        // update windspeed text
        double windspeed = (double) weatherData.get("windspeed");
        windspeedText.setText("Windspeed " + windspeed + " km/h");
        
        
        // end of retrieve weather data  of the current time
        
        
       JSONObject weatherData2 = cairoApi.getWeatherData2(userInput);

       if (weatherData2 != null) {
       updateLabelsForFirstDay(weatherData2);
    
//    JSONArray days = (JSONArray) weatherData2.get("days");
//
//    if (days != null) {
//        for (Object dayObj : days) {
//            JSONObject day = (JSONObject) dayObj;
//            System.out.println("Date: " + day.get("date"));
//            System.out.println("Weather Condition: " + day.get("weather_condition"));
//            System.out.println();
//        }
//    } else {
//        System.out.println("No weather data available for days.");
//    }
      }
      else {
         System.out.println("No weather data available.");
      }



    }

    private void updateWeatherImage(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    


private void updateLabelsForFirstDay(JSONObject weatherData2) {
    try {
             // Extract the "days" array from the JSON object
        JSONArray daysArray = (JSONArray) weatherData2.get("days");

        if (daysArray != null && daysArray.size() > 0) {
            // Extract data for the first day from the "days" array
            JSONObject firstDayData = (JSONObject) daysArray.get(0);
            
            
             // Parse the date string and get the day of the week
            String dateString = (String) firstDayData.get("date");
            LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

            // Update labels with data for the first day, including the day of the week
            date1.setText("" + dayOfWeek + ", " + dateString);
            con1.setText("" + firstDayData.get("weather_condition"));
            temp1.setText("" + firstDayData.get("temperature"));
            String weatherCondition2 = (String) firstDayData.get("weather_condition");
            updateWeatherImage2(weatherCondition2);
            
            // Extract data for the second day from the "days" array
            JSONObject secondDayData = (JSONObject) daysArray.get(1);
            // Parse the date string and get the day of the week
            String dateString2 = (String) secondDayData.get("date");
            LocalDate localDate2 = LocalDate.parse(dateString2, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek2 = localDate2.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date2.setText("" + dayOfWeek2 + ", " + dateString2);
            con2.setText("" + secondDayData.get("weather_condition"));
            temp2.setText("" + secondDayData.get("temperature"));
            String weatherCondition3 = (String) secondDayData.get("weather_condition");
            updateWeatherImage3(weatherCondition3);
            
             // Extract data for the third day from the "days" array
            JSONObject thirdDayData = (JSONObject) daysArray.get(2);
            // Parse the date string and get the day of the week
            String dateString3 = (String) thirdDayData.get("date");
            LocalDate localDate3 = LocalDate.parse(dateString3, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek3 = localDate3.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date3.setText("" + dayOfWeek3 + ", " + dateString3);
            con3.setText("" + thirdDayData.get("weather_condition"));
            temp3.setText("" + thirdDayData.get("temperature"));
            String weatherCondition4 = (String) thirdDayData.get("weather_condition");
            updateWeatherImage4(weatherCondition4);
            
            
              // Extract data for the four day from the "days" array
            JSONObject fourDayData = (JSONObject) daysArray.get(3);
            // Parse the date string and get the day of the week
            String dateString4 = (String) fourDayData.get("date");
            LocalDate localDate4 = LocalDate.parse(dateString4, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek4 = localDate4.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date4.setText("" + dayOfWeek4 + ", " + dateString4);
            con4.setText("" + fourDayData.get("weather_condition"));
            temp4.setText("" + fourDayData.get("temperature"));
            String weatherCondition5 = (String) fourDayData.get("weather_condition");
            updateWeatherImage5(weatherCondition5);
            
                        
              // Extract data for the five day from the "days" array
            JSONObject fiveDayData = (JSONObject) daysArray.get(4);
            // Parse the date string and get the day of the week
            String dateString5 = (String) fiveDayData.get("date");
            LocalDate localDate5 = LocalDate.parse(dateString5, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek5 = localDate5.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date5.setText("" + dayOfWeek5 + ", " + dateString5);
            con5.setText("" + fiveDayData.get("weather_condition"));
            temp5.setText("" + fiveDayData.get("temperature"));
            String weatherCondition6 = (String) fiveDayData.get("weather_condition");
            updateWeatherImage6(weatherCondition6);
            
                        
                        
              // Extract data for the six day from the "days" array
            JSONObject sixDayData = (JSONObject) daysArray.get(5);
            // Parse the date string and get the day of the week
            String dateString6 = (String) sixDayData.get("date");
            LocalDate localDate6 = LocalDate.parse(dateString6, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek6 = localDate6.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date6.setText("" + dayOfWeek6 + ", " + dateString6);
            con6.setText("" + sixDayData.get("weather_condition"));
            temp6.setText("" + sixDayData.get("temperature"));
            String weatherCondition7 = (String) sixDayData.get("weather_condition");
            updateWeatherImage7(weatherCondition7);
            
                                    
                        
              // Extract data for the seven day from the "days" array
            JSONObject sevenDayData = (JSONObject) daysArray.get(6);
            // Parse the date string and get the day of the week
            String dateString7 = (String) sevenDayData.get("date");
            LocalDate localDate7 = LocalDate.parse(dateString7, DateTimeFormatter.ISO_LOCAL_DATE);
            String dayOfWeek7 = localDate7.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            // Update labels with data for the first day, including the day of the week
            date7.setText("" + dayOfWeek7 + ", " + dateString7);
            con7.setText("" + sevenDayData.get("weather_condition"));
            temp7.setText("" + sevenDayData.get("temperature"));
            String weatherCondition8 = (String) sevenDayData.get("weather_condition");
            updateWeatherImage8(weatherCondition8);
            
        } else {
            System.out.println("No weather data available for days.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}   

            
        private void updateWeatherImage2(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage2.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
        private void updateWeatherImage3(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage3.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } 
           
        private void updateWeatherImage4(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage4.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        private void updateWeatherImage5(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage5.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
                   
        private void updateWeatherImage6(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage6.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
        private void updateWeatherImage7(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage7.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
        private void updateWeatherImage8(String weatherCondition) {
        try {
            Image image = new Image(new FileInputStream("src/images/" + weatherCondition.toLowerCase() + ".png"));
            weatherConditionImage8.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }   
    
}
