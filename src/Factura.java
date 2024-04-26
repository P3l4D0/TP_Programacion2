import java.util.ArrayList;
import java.util.Iterator;


public class Factura extends Comprobante {
    private ArrayList<Producto> mProducto;
    private float total;
    private Cliente mCliente;

    public Factura(char t, int n, Fecha f, Cliente cli) {
        super(t, n, f);
        setMCliente(cli);
        mProducto = new ArrayList<>();
    }

    public ArrayList<Producto> getMProducto() {
        return mProducto;
    }

    public void mProducto(ArrayList<Producto> mProducto) {
        this.mProducto = mProducto;
    }

    public Cliente getCliente() {
        return mCliente;
    }

    public void setMCliente(Cliente mCliente) {
        this.mCliente = mCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void agregarProducto(Producto p) {
        mProducto.add(p);
        setTotal(getTotal() + p.getPrecio());
    }

    public void mostrarProductos(){
        Iterator<Producto> iter = mProducto.iterator();
        while (iter.hasNext()) {
            Producto p = iter.next();
            System.out.printf("Codigo: %d Descripcion: %s Precio: %5.2f \n",
            p.getCodigo(), p.getDescripcion(), p.getPrecio());
        }

    }

    public void mostrar(){
        System.out.printf("Tipo: %c Fecha: %d%d%d\n",
        getTipo(), getNumero(), getFecha().getDia(), getFecha().getMes(), getFecha().getAnio());
        System.out.printf("Cliente: \n");
        System.out.printf("Codigo: %d Razon Social: %s \n",
        mCliente.getCodigo(), mCliente.getRazonSocial());
        System.out.printf("Productos: \n");
        mostrarProductos();
        System.out.printf("Total: %6.2f\n", getTotal());
    }

}
