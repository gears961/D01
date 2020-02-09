package visitor;

public abstract class ItemVisitor {

    public abstract void visitBulkItem(BulkItem item);

    public abstract void visitPackagedItem(PackagedItem item);

}