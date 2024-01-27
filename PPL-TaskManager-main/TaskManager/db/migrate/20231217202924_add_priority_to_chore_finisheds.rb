class AddPriorityToChoreFinisheds < ActiveRecord::Migration[7.1]
  def change
    add_column :chore_finisheds, :priority, :string
  end
end
