
package tld;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marc
 */
public class MyTags extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        Date currentDate= new Date();        
        SimpleDateFormat sdf= new SimpleDateFormat("EEEEEE, d MMM yyyy HH:mm:ss");//("dd/MM/yyyy");//E, d MMM yyyy HH:mm:ss Z
        String currendDatef = sdf.format(currentDate);
//        DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
//        String currentDateFormatted = dfs.format(currentDate);         
//        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
       // String  dateNow= days[c.getTime().]+
//String  dateNow = days[d.getDay()].concat(", ", months[d.getMonth()], " ", d.getDate(), "th ", d.getFullYear(), ", ", d.getHours(), ":", d.getMinutes());
        try {
            JspWriter out = pageContext.getOut();
            out.print(currendDatef);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}
