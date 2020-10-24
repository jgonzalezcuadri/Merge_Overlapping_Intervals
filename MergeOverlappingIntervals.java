// Ein Java-Programm zum Zusammenführen überlappender Intervalle

import java.util.Arrays;

import java.util.Comparator;

import java.util.Stack;


// Klasse, die Intervalle repräsentiert

class Interval
{

    int start,end;

    Interval(int start, int end)

    {

        this.start=start;

        this.end=end;

    }
}

// Klasse, die die Intervalle verarbeitet

class MergeOverlappingIntervals {
 

    // Die Main-Funktion, die eine Reihe von Intervallen nimmt,
    // überlappende Intervalle zusammenführt und das Ergebnis ausdruckt

    public static void mergeIntervals(Interval arr[]) 

    { 

        // Test, ob die gegebene Menge mindestens ein Intervall hat 

        if (arr.length <= 0) 

            return; 

   

        // Einen leeren Intervallstapel erstellen 

        Stack<Interval> stack=new Stack<>();

   

        // Die Intervalle in aufsteigender Reihenfolge der Startzeit sortieren  

        Arrays.sort(arr,new Comparator<Interval>(){

            public int compare(Interval i1,Interval i2)

            {

                return i1.start-i2.start;

            }

        });

   

        // Das erste Intervall zum Stapeln schieben 

        stack.push(arr[0]); 

   

        // Mit dem nächsten Intervall beginnen und ggf. zusammenführen 

        for (int i = 1 ; i < arr.length; i++) 

        { 

            // Intervall vom obersten Stapel holen

            Interval top = stack.peek(); 

   

            // enn sich das aktuelle Intervall nicht mit der Stapeloberseite überlappt,

            // auf den Stapel schieben 

            if (top.end < arr[i].start) 

                stack.push(arr[i]); 

   

            // Andernfalls die Endzeit von oben aktualisieren, wenn das Ende des

            // aktuellen Intervalls mehr ist 

            else if (top.end < arr[i].end) 

            { 

                top.end = arr[i].end; 

                stack.pop(); 

                stack.push(top); 

            } 

        } 

   

        // Inhalt des Stapels drucken

        System.out.print("The Merged Intervals are: ");

        while (!stack.isEmpty()) 

        { 

            Interval t = stack.pop(); 

            System.out.print("["+t.start+","+t.end+"] ");

        }  

    }  
 

    public static void main(String args[]) {

        Interval arr[]=new Interval[4];

        
	// Intervalle: [25,30] [2,19] [14, 23] [4,8]

        arr[0]=new Interval(25,30);

        arr[1]=new Interval(2,19);

        arr[2]=new Interval(14,23);

        arr[3]=new Interval(4,8);
        
        mergeIntervals(arr);

    }
}
