package visitor;

public class PrintVisitor extends ItemVisitor{

    private String list;

    public PrintVisitor() {
        this.list = "Item list:\n";
    }

    @Override
    public void visitBulkItem(BulkItem item) {
        list += item.toString() + "\n";
    }

    @Override
    public void visitPackagedItem(PackagedItem item) {
        list += item.toString() + "\n";
    }

    public String getList() {
        return list;
    }
}