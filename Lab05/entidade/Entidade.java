/*Define metodos base para todas as entidades */
package entidade;
public interface Entidade {
    int getX();
    int getY();
    int getZ();
    TipoEntidade getEntidade();
    String getDescricao();
    char getRepresentacao();
}
