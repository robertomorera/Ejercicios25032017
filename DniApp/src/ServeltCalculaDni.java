

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeltCalculaDni
 */
@WebServlet("/ServeltCalculaDni")
public class ServeltCalculaDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final char [] letraDNI={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltCalculaDni() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num_dni=request.getParameter("dni");
		System.out.println("DNI PASADO "+num_dni);
		int n_dni=Integer.parseInt(num_dni);
		char letra_dni=calcularLetraDni(n_dni);
		String mensaje_respuesta="SU DNI COMPLETO ES "+num_dni+"-"+letra_dni; 
		PrintWriter pw=response.getWriter();
		response.setContentType("text/plain");
		pw.write(mensaje_respuesta);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	   
	private char calcularLetraDni (int num_dni){
		char letra_dni;
	    int n= num_dni %23;
	    letra_dni=letraDNI[n];
		return letra_dni;
	}
	
	

}
