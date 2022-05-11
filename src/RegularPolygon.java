public class RegularPolygon {
    double length;
    int vertices;
    double internalAngle;
    double[] center = new double[2];
    double[][] verticesPosition = new double[100][3];

    RegularPolygon(int vertices, double length, double[] center){
        this.vertices = vertices;
        this.length = length;
        this.center = center;
        this.internalAngle = (vertices - 2) * 180 / vertices;  //(n-2)*180 is formula to find total internal angle

        MakeVertices();
        Show();
        Draw();
    }

    public void Show(){
        System.out.println("Attributes:" +
                           "\n vertices = " + vertices +
                           "\n length = " + length +
                           "\n internalAngle = " + internalAngle);

        for(int i = 0; i < vertices; i++){
            System.out.println(" Point " + (i+1) + " = (" + verticesPosition[i][0] + ", " + verticesPosition[i][1] + ")");
        }
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

        return (double) vertices * Math.pow(length, 2) * (Math.cos(arg)/Math.sin(arg));
    }

    //unnecessary methods

    //method to roughly draw the shape
    public void Draw(){
        //getting a sorted version of the position array
        double [][] sortedPos = RearrangePositions(verticesPosition, vertices);

        //height
        int[] height = {(int) sortedPos[0][1], 0};

        //finding lowestXvalue for printing
        int lowestXvalue = (int) sortedPos[0][0];
        for(int i = 1; i < vertices; i++){
            if(lowestXvalue > sortedPos[i][0]){
                lowestXvalue = (int) sortedPos[0][0];
            }
        }

        //drawing
        for(int i = 0; i < vertices; i++){
            if(height[0] == (int)sortedPos[i][1]){
                for(int j = 0; j < ((int)sortedPos[i][0] - lowestXvalue); j++){
                    System.out.print(" ");
                }
                System.out.print(sortedPos[i][2]);
            }
            else{
                height[1] = height[0] - (int) sortedPos[i][1];
                height[0] = (int) sortedPos[i][1];

                for(int j = 0; j < height[1]; j++){
                    you were here trying to add spaces
                }
            }
        }

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
