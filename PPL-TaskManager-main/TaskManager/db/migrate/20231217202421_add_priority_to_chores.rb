class AddPriorityToChores < ActiveRecord::Migration[7.1]
  def change
    add_column :chores, :priority, :string
  end
end
