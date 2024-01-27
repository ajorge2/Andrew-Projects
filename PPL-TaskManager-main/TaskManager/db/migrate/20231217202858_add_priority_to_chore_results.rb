class AddPriorityToChoreResults < ActiveRecord::Migration[7.1]
  def change
    add_column :chore_results, :priority, :string
  end
end
