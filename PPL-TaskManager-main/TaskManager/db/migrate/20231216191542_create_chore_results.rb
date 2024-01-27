class CreateChoreResults < ActiveRecord::Migration[7.1]
  def change
    create_table :chore_results do |t|
      t.string :name
      t.datetime :datetime
      t.string :description
      t.string :location
      t.string :collaborators

      t.timestamps
    end
  end
end
