package barqsoft.footballscores;

import android.content.res.Resources;

/**
 * Utilities.java
 * Created by yehya khaled on 3/3/2015.
 */

public class Utilies
{
    public static String getLeague(int league_num)
    {
        Resources res = Resources.getSystem();
        switch (league_num)
        {
            case DatabaseContract.BUNDESLIGA1 : return res.getString(R.string.bundesliga1);
            case DatabaseContract.BUNDESLIGA2 : return res.getString(R.string.bundesliga2);
            case DatabaseContract.LIGUE1: return res.getString(R.string.ligue1);
            case DatabaseContract.LIGUE2: return res.getString(R.string.ligue2);
            case DatabaseContract.PREMIER_LEAGUE : return res.getString(R.string.premier_league);
            case DatabaseContract.PRIMERA_DIVISION : return res.getString(R.string.primera_division);
            case DatabaseContract.SEGUNDA_DIVISION : return res.getString(R.string.segunda_division);
            case DatabaseContract.SERIE_A : return res.getString(R.string.serie_a);
            case DatabaseContract.PRIMERA_LIGA : return res.getString(R.string.primera_liga);
            case DatabaseContract.BUNDESLIGA3 : return res.getString(R.string.bundesliga3);
            case DatabaseContract.EREDIVISIE: return res.getString(R.string.eredivisie);
            case DatabaseContract.CHAMPIONS_LEAGUE : return res.getString(R.string.champions_league);
            default: return res.getString(R.string.unknown_league) + "(" + String.valueOf(league_num) + ")";
        }
    }
    public static String getMatchDay(int match_day,int league_num)
    {
        Resources res = Resources.getSystem();
        if(league_num == DatabaseContract.CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return res.getString(R.string.group_stages) + ", " + res.getString(R.string.matchday) + " : 6";
            }
            else if(match_day == 7 || match_day == 8)
            {
                return res.getString(R.string.first_knockout_round);
            }
            else if(match_day == 9 || match_day == 10)
            {
                return res.getString(R.string.quarter_final);
            }
            else if(match_day == 11 || match_day == 12)
            {
                return res.getString(R.string.semi_final);
            }
            else
            {
                return res.getString(R.string.final_text);
            }
        }
        else
        {
            return res.getString(R.string.matchday) + " : " + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName (String teamname)
    {
        if (teamname==null){return R.drawable.no_icon;}
        switch (teamname)
        { //This is the set of icons that are currently in the app. Feel free to find and add more
            //as you go.
            case "Arsenal London FC" : return R.drawable.arsenal;
            case "Manchester United FC" : return R.drawable.manchester_united;
            case "Swansea City" : return R.drawable.swansea_city_afc;
            case "Leicester City" : return R.drawable.leicester_city_fc_hd_logo;
            case "Everton FC" : return R.drawable.everton_fc_logo1;
            case "West Ham United FC" : return R.drawable.west_ham;
            case "Tottenham Hotspur FC" : return R.drawable.tottenham_hotspur;
            case "West Bromwich Albion" : return R.drawable.west_bromwich_albion_hd_logo;
            case "Sunderland AFC" : return R.drawable.sunderland;
            case "Stoke City FC" : return R.drawable.stoke_city;
            default: return R.drawable.no_icon;
        }
    }
}
