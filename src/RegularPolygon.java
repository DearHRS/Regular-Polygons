public class RegularPolygon {
    String name;
    double length;
    int vertices;
    double internalAngle;
    double[] center = new double[2];
    double[][] verticesPosition = new double[100][3];

    RegularPolygon(String name, int vertices, double length, double[] center){
        this.name = name;
        this.vertices = vertices;
        this.length = length;
        this.center = center;
        this.internalAngle = (vertices - 2) * 180 / vertices;  //(n-2)*180 is formula to find total internal angle

        MakeVertices();

        Show();
    }

    public void Show(){
        System.out.println("\nAttributes of the " + name + ":" +
                           "\n       vertices = " + vertices +
                           "\n         length = " + length +
                           "\n  internalAngle = " + internalAngle + "\n");

        for(int i = 0; i < vertices; i++){
            System.out.println(" Point " + (i+1) + " = (" + verticesPosition[i][0] + ", " + verticesPosition[i][1] + ")");
        }

        System.out.println("\n      Perimeter = " + Perimeter());
        System.out.println("           Area = " + Area());

        Draw();
    }

    void MakeVertices(){
        //first seed vertex
        verticesPosition[0][0] = center[0] - (length / 2);
        verticesPosition[0][1] = center[1] - (length / 2);
        verticesPosition[0][2] = 1;

        //getting radian value of the internal value
        double[] angle = new double[2];
        angle[0] = Funx.DegreesToRadians(180 - (int) internalAngle);
        angle[1] = 0.0;

        //creating rest of the vertices
        for(int i = 1; i <= vertices - 1; i++){
            /*
            verticesPosition[i][0] = verticesPosition[i - 1][0] + Math.round(Math.cos(angle[1]) * length * 100000.0) / 100000.0;
            verticesPosition[i][1] = verticesPosition[i - 1][1] + Math.round(Math.sin(angle[1]) * length * 100000.0) / 100000.0;*/

            //value along x
            verticesPosition[i][0] = verticesPosition[i - 1][0] + Math.cos(angle[1]) * length;
            verticesPosition[i][0] = Math.round(verticesPosition[i][0] * 100000.0) / 100000.0;

            //value along y
            verticesPosition[i][1] = verticesPosition[i - 1][1] + Math.sin(angle[1]) * length;
            verticesPosition[i][1] = Math.round(verticesPosition[i][1] * 100000.0) / 100000.0;

            //point number and updating angle
            verticesPosition[i][2] = i + 1;
            angle[1] += angle[0];
        }
    }

    //Method to find perimeter
    public double Perimeter(){
        return (double) vertices * length;
    }


    //Method to find area
    public double Area(){
        double arg = Math.PI / (double) vertices;

        return (double) Math.round(((double) vertices * Math.pow(length, 2) * (Math.cos(arg)/Math.sin(arg) / 4)) * 100000) / 100000;
    }

    //unnecessary methods not related to given task

    //method to roughly draw the shape
    public void Draw(){
        //getting a sorted version of the position array
        double [][] sortedPos = RearrangePositions(verticesPosition, vertices);

        //variable to store lowest value of x, used for drawing first points per line (so index is not negative)
        double lowestXValue = sortedPos[0][0];


        //finding lowest X values
        for(int i = 1; i < vertices; i++){
            if(lowestXValue > sortedPos[i][0]){
                lowestXValue = sortedPos[i][0];
            }
        }

        //drawing empty spaces along x axis between edge and first point
        for(int i = 0; i < (int)(sortedPos[0][0] - lowestXValue); i++){
            System.out.print("   ");
        }
        System.out.print(sortedPos[0][2]);

        //drawing points layer by layer
        for(int i = 1; i < vertices; i++){
            //this part only activates when we got second point to draw on same line
            if(sortedPos[i - 1][1] == sortedPos[i][1]){
                for(int j = 0; j < (int)(sortedPos[i][0] - sortedPos[i - 1][0]); j++){
                    System.out.print("   ");
                }
                System.out.print(sortedPos[i][2]);

            }

            //this part only activates when we got first point to draw on next line
            else{
                //drawing necessary amount of new line between last line and next line
                for(int j = 0; j < Math.round(sortedPos[i - 1][1] - sortedPos[i][1]); j++){
                    System.out.println();
                }

                //drawing necessary spaces between first point and edge, then drawinf first point
                for(int j = 0; j < (int)(sortedPos[i][0] - lowestXValue); j++){
                    System.out.print("   ");
                }
                System.out.print(sortedPos[i][2]);

            }
        }

        //algorithm
        /*first point drawn after giving necessary amount of spaces between edge and the point
        for cycle from second element and onwards
                if next point is in same y value
                    then from first point on same line next point is drawn after giving enough spaces
                else
                    draw the required new lines between last line and next line
                    then draw first point of next line after giving enough spaces*/
    }


    //custom method for rearraning positions from top to bottom, left to right
    public double[][] RearrangePositions(double[][] output, int vertices){
        double[] dummy = new double[3];

        //sorting in descending order along y axis
        for(int i = 0; i < vertices; i++){
            for(int j = i; j < vertices; j++){
                if(output[i][1] < output[j][1]){
                    dummy = output[i];
                    output[i] = output[j];
                    output[j] = dummy;
                }
            }
        }

        //sorting in ascending order along x axis
        for(int i = 0; i < vertices; i++){
            for(int j = i; j < vertices; j++){
                if(output[i][1] == output[j][1]){
                    if(output[i][0] > output[j][0]){
                        dummy = output[i];
                        output[i] = output[j];
                        output[j] = dummy;
                    }
                }
            }
        }

        return output;
    }
}
