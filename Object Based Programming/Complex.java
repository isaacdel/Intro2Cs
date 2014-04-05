/**
 * 
 */
public final class Complex {
	private static final int DIVIDE_HALF = 2;
	/**
	 * This constant, EPSILON, is used when comparing double numbers.
	 2 double variables are considered equal if the distance between them is
	 less than EPSILON.

	 */
	public static final double EPSILON=1.0E-6;
	private double realNumber;
	private double imaginaryNumber;
	private double numberPower(double n){
		return (n*n);
	}
	/**
	 * Constructs a complex number.

	 * @param real The real part of the complex number.
	 * @param img The imaginary part of the complex number.
	 */
	public Complex (double real,double img){
		realNumber=real;
		imaginaryNumber=img;	
	}
	//copy constractor
	public Complex (Complex modNumber){
		realNumber=modNumber.realNumber;
		imaginaryNumber=modNumber.imaginaryNumber;
	}
	/**
	 * Returns the real part of the complex number.

	 * @return The real part of the complex number.
	 */
	public double getReal(){
		return realNumber;
	}
	/**
	 * Returns the imaginary part of the complex number.

	 * @return The imaginary part of the complex number.
	 */
	public double getImg(){
		return imaginaryNumber;
	}
	/**
	 * Returns the absolute value of the complex number.

	 * @return The absolute value of the complex number.
	 */
	public double getAbsValue(){
		double abs=Math.sqrt(numberPower(realNumber)+numberPower(imaginaryNumber));
		return abs;
	}
	/**
	 * Returns the polar angle of the complex number.
	 The returned angle sholuld be between -pi (greater than) to pi (less equal than).
	 -pi < getAngle() <= pi. The angle on 0+0i is defined to be 0.

	 * @return The polar angle of this complex number, in the range of -pi to pi.
	 */
	public double getAngle(){
		if ((realNumber==0)&&(imaginaryNumber==0)){
			return 0;
		}
		else{
			double complexDivide=(imaginaryNumber/realNumber);
			if (realNumber>0){
				return Math.atan(complexDivide);
			}
			if((realNumber<0)&&(imaginaryNumber>=0)){
				return Math.atan(complexDivide)+Math.PI;
			}
			if((realNumber<0)&&(imaginaryNumber<0)){
				return Math.atan(complexDivide)-Math.PI;
			}
			if ((realNumber==0)&&(imaginaryNumber>0)){
				return (Math.PI)/Complex.DIVIDE_HALF;
			}
			if(realNumber==0&&imaginaryNumber<0){
				return -1*((Math.PI)/Complex.DIVIDE_HALF);
			}
			return 0;
		}	
	}
	/**
	 * Compares this complex number to other and check if they are equal.
 Remember that the imaginary and real parts are double variables so you should
 compare them in the appropriate way (using the EPSILON constant).

	 * @param other The other complex number to compare.

	 * @return True if this equals to other,
         false otherwise (false for null input as well).
	 */
	public boolean equals(Complex other){
		if (other!=null){
			if (Math.abs(realNumber-other.realNumber)<EPSILON 
					&& Math.abs(imaginaryNumber-other.imaginaryNumber)<EPSILON){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	/**
	 * Adds the other complex number to this complex number. 
	 The result is returned as a new complex number. 
	 Other and this complex numbers are not affected.

	 * @param other The complex number to add.

	 * @return The resulted complex number, null in case of null input.
	 */
	public Complex plus(Complex other){
		if (other!=null){
			return new Complex(realNumber+other.realNumber,imaginaryNumber+other.imaginaryNumber);
		}
		else{
			return null;
		}
	}
	/**
	 * Subtracts the given complex number from this complex number. 
	 The result is returned as a new complex num. 
	 Other and this complex numbers are not affected.

	 * @param other The complex number to subtract.

	 * @return The resulted complex number, null in case of null input.
	 */
	public Complex minus(Complex other){
		if (other!=null){
			return new Complex(realNumber-other.realNumber,imaginaryNumber-other.imaginaryNumber);
		}
		else{
			return null;
		}
	}
	/**
	 * Performs multiplication with the given complex number. 
 The result is returned as a new complex num.

	 * @param other The complex number to perform the multiplication with.

	 * @return The multiplication result (complex number), null in case of null input.
	 */
	public Complex mult(Complex other){
		if (other!=null){
			return new Complex(((realNumber*other.realNumber)-(imaginaryNumber*other.imaginaryNumber))
					,((realNumber*other.imaginaryNumber)+(imaginaryNumber*other.realNumber)));
		}
		else{
			return null;
		}
	}
	/**
	 * Finds the square of this complex number.
 The result is returned as a new complex num.

	 * @return The square of this complex number.
	 */
	public Complex square(){
		return new Complex((numberPower(realNumber))+((-1)*(numberPower(imaginaryNumber)))
				,Complex.DIVIDE_HALF*realNumber*imaginaryNumber);
	}
	/**
	 * Perform division with the given complex number. 
	 The result is returned in a new complex num. 
	 Assumes that division by zero will not be required.

	 * @param other The divisor (complex number).

	 * @return The division result (complex number), null in case of null input.
	 */
	public Complex div(Complex other){
		if (other!=null){
			return new Complex((realNumber*other.realNumber+imaginaryNumber*other.imaginaryNumber)/
					((numberPower(other.realNumber))+(numberPower(other.imaginaryNumber))),
					((imaginaryNumber*other.realNumber)-(realNumber*other.imaginaryNumber))/
					(numberPower(other.realNumber)+numberPower(other.imaginaryNumber)));
		}
		else{
			return null;
		}
	}
	/**
	 * Finds the conjugate of this complex number.

	 * @return The conjugate of this complex number.
	 */
	public Complex conjugate(){
		return new Complex (realNumber,(-1)*imaginaryNumber);
	}
	/**
	 * Finds the escape time of this complex number from the given Mandelbrot radius:
	 The escape time is the index of the first element in the sequence (z_i) 
	 which is outside the circle with the radius given.
	 Further explanations are found in ex4.


	 * @param radius The Mandelbrot radius.
	 * @param maxIterations The maximum escape time to check.

	 * @return The escape time of this complex number, for example if z_5 is
	 the first sequence element outside the radius circle we will return 5.
	 If this complex number did not escape in maxIteration return -1.
	 */
	public int escapeTime(int radius,int maxIterations){

		Complex runningNumber=new Complex(0,0);

		for (int i=1;i<=maxIterations;i++){		
			runningNumber=runningNumber.square().plus(this);
			double nPlusOne=runningNumber.getAbsValue();
			if(nPlusOne>=radius){
				return i;
			}
		}
		return -1;
	}
}

